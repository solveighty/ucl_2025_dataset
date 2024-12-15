import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Typography, Card, CardContent, CardMedia, CircularProgress, Grid } from '@mui/material';

const TeamDetail = () => {
  const { id } = useParams(); // Use `id` here as it matches the route parameter
  const [team, setTeam] = useState(null);
  const [players, setPlayers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    if (id) {
      fetchTeamAndPlayers(id); // Pass the id directly to the fetch function
    }
  }, [id]);

  const fetchTeamAndPlayers = async (teamId) => {
    setLoading(true);
    try {
      const teamResponse = await fetch(`http://localhost:8080/teams/${teamId}`, {
        headers: {
          'Authorization': `Bearer ${localStorage.getItem('token')}`,
        },
      });

      if (!teamResponse.ok) throw new Error('Error al obtener el equipo');
      const teamData = await teamResponse.json();

      console.log('Equipo y jugadores:', teamData); // Verify the team data

      setTeam(teamData); // Set team details
      setPlayers(teamData.players); // Set players list

    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <CircularProgress />;
  if (error) return <Typography color="error">{error}</Typography>;

  return (
    <div style={{ padding: '20px' }}>
      <Typography variant="h4" gutterBottom>
        {team.team}
      </Typography>
      <Card sx={{ maxWidth: 300, marginBottom: 3 }}>
        <CardMedia
          component="img"
          height="200"
          image={team.logo}
          alt={team.team}
        />
        <CardContent>
          <Typography variant="body1">Country: {team.country}</Typography>
        </CardContent>
      </Card>

      <Typography variant="h5" gutterBottom>
        Players
      </Typography>

      {/* Grid to display player cards */}
      <Grid container spacing={3}>
        {players.length > 0 ? (
          players.map((player) => (
            <Grid item xs={12} sm={6} md={4} key={player.playerId}>
              <Card sx={{ maxWidth: 300 }}>
                <CardMedia
                  component="img"
                  height="200"
                  image={player.photoUrl}
                  alt={player.playerName}
                />
                <CardContent>
                  <Typography variant="h6">{player.playerName}</Typography>
                  <Typography variant="body2">Position: {player.position || 'N/A'}</Typography>
                  <Typography variant="body2">Nationality: {player.nationality}</Typography>
                  <Typography variant="body2">Age: {player.age}</Typography>
                  <Typography variant="body2">Height: {player.height || 'N/A'} cm</Typography>
                  <Typography variant="body2">Weight: {player.weight || 'N/A'} kg</Typography>
                </CardContent>
              </Card>
            </Grid>
          ))
        ) : (
          <Typography>No players found for this team.</Typography>
        )}
      </Grid>
    </div>
  );
};

export default TeamDetail;
