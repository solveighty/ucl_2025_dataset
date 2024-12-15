import { useState, useEffect } from 'react';
import { Grid, Card, CardContent, CardMedia, Typography, CircularProgress, Alert } from '@mui/material';
import { Link } from 'react-router-dom';

const Players = () => {
  const [players, setPlayers] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    fetchPlayers();
  }, []);

  const fetchPlayers = async () => {
    try {
      const response = await fetch('http://localhost:8080/players', {
        headers: {
          'Authorization': `Bearer ${localStorage.getItem('token')}`
        }
      });
      if (!response.ok) throw new Error('Failed to fetch players');
      const data = await response.json();
      setPlayers(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  if (loading) return <CircularProgress sx={{ display: 'block', margin: 'auto', mt: 5 }} />;
  if (error) return <Alert severity="error">{error}</Alert>;

  return (
    <Grid container spacing={3} sx={{ p: 3 }}>
      {players.map((player) => (
        <Grid item xs={12} sm={6} md={4} key={player.playerId}>
          <Card component={Link} to={`/players/${player.playerId}`} sx={{ textDecoration: 'none' }}>
            <CardMedia
              component="img"
              height="200"
              image={player.photoUrl}
              alt={player.playerName}
            />
            <CardContent>
              <Typography variant="h6">{player.playerName}</Typography>
              <Typography variant="body2">
                <strong>Position:</strong> {player.position || 'N/A'}
              </Typography>
              <Typography variant="body2">
                <strong>Nationality:</strong> {player.nationality}
              </Typography>
            </CardContent>
          </Card>
        </Grid>
      ))}
    </Grid>
  );
};

export default Players;
