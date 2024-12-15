import { useState, useEffect } from 'react';
import { Grid, Card, CardContent, CardMedia, Typography, CircularProgress, Alert } from '@mui/material';
import { Link } from 'react-router-dom';

const Teams = () => {
  const [teams, setTeams] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    setLoading(true); // Asegúrate de que el estado de carga esté activado
    fetchTeams(); // Llamada a la función para obtener los equipos
  }, []);

  // Función para obtener los equipos desde la API
  const fetchTeams = async () => {
    try {
      const response = await fetch('http://localhost:8080/teams', {
        headers: {
          'Authorization': `Bearer ${localStorage.getItem('token')}` // Usa el token almacenado en localStorage
        }
      });

      if (!response.ok) throw new Error('Failed to fetch teams');
      const data = await response.json();
      setTeams(data); // Guarda los equipos obtenidos en el estado
    } catch (err) {
      setError(err.message); // Establece el mensaje de error si ocurre un fallo
    } finally {
      setLoading(false); // Finaliza la carga
    }
  };

  // Si está cargando, muestra el indicador de carga
  if (loading) return <CircularProgress sx={{ display: 'block', margin: 'auto', mt: 5 }} />;
  
  // Si ocurre un error, muestra el mensaje de error
  if (error) return <Alert severity="error">{error}</Alert>;

  return (
    <Grid container spacing={3} sx={{ p: 3 }}>
      {teams.map((team) => (
        <Grid item xs={12} sm={6} md={4} key={team.teamId}>
          <Card component={Link} to={`/teams/${team.teamId}`} sx={{ textDecoration: 'none' }}>
            <CardMedia
              component="img"
              height="140"
              image={team.logo} // La URL del logo del equipo
              alt={team.team} // Nombre del equipo
            />
            <CardContent>
              <Typography variant="h6">{team.team}</Typography> {/* Nombre del equipo */}
              <Typography variant="body2" color="text.secondary">
                {team.country} {/* País del equipo */}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      ))}
    </Grid>
  );
};

export default Teams;
