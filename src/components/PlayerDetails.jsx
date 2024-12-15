import { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import { Grid, AppBar, Toolbar, Tab, Tabs, Box, Typography, CircularProgress, Alert, Card, CardContent } from '@mui/material';

const PlayerDetails = () => {
  const { playerId } = useParams(); // Obtener el playerId de la URL
  const [stats, setStats] = useState(null);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);
  const [activeTab, setActiveTab] = useState(0); // Controla la pestaña activa

  const fetchStats = async (statType) => {
    try {
      const response = await fetch(`http://localhost:8080/${statType}/${playerId}`, {
        headers: {
          'Authorization': `Bearer ${localStorage.getItem('token')}`
        }
      });
      if (!response.ok) throw new Error('Failed to fetch stats');
      const data = await response.json();
      setStats(data);
    } catch (err) {
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => {
    setLoading(true);
    fetchStats('attacking-stats'); // Cargar las estadísticas por defecto (por ejemplo, AttackingStats)
  }, [playerId]);

  const handleTabChange = (event, newTab) => {
    setActiveTab(newTab);
    setLoading(true);
    switch (newTab) {
      case 0:
        fetchStats('attacking-stats');
        break;
      case 1:
        fetchStats('attempts-stats');
        break;
      case 2:
        fetchStats('defending-stats');
        break;
      case 3:
        fetchStats('disciplinary-stats');
        break;
      case 4:
        fetchStats('distribution-stats');
        break;
      case 5:
        fetchStats('goalkeeping-stats');
        break;
      case 6:
        fetchStats('goals-stats');
        break;
      case 7:
        fetchStats('key-stats');
        break;
      default:
        break;
    }
  };

  if (loading) return <CircularProgress sx={{ display: 'block', margin: 'auto', mt: 5 }} />;
  if (error) return <Alert severity="error">{error}</Alert>;

  const renderStats = () => {
    if (!stats) return null;

    const { player, ...rest } = stats;

    return Object.entries(rest).map(([key, value]) => (
      <Grid item xs={12} sm={6} md={4} key={key}>
        <Card variant="outlined">
          <CardContent>
            <Typography variant="h6">{key.replace(/([A-Z])/g, ' $1').toUpperCase()}</Typography>
            <Typography variant="body1">{JSON.stringify(value, null, 2)}</Typography>
          </CardContent>
        </Card>
      </Grid>
    ));
  };

  return (
    <Box sx={{ width: '100%' }}>
      <AppBar position="static">
        <Toolbar>
          <Tabs value={activeTab} onChange={handleTabChange} variant="scrollable" scrollButtons="auto">
            <Tab label="Attacking Stats" />
            <Tab label="Attempts Stats" />
            <Tab label="Defending Stats" />
            <Tab label="Disciplinary Stats" />
            <Tab label="Distribution Stats" />
            <Tab label="Goalkeeping Stats" />
            <Tab label="Goals Stats" />
            <Tab label="Key Stats" />
          </Tabs>
        </Toolbar>
      </AppBar>
      <Grid container spacing={3} sx={{ p: 3 }}>
        <Grid item xs={12}>
          <Typography variant="h4" gutterBottom>
            {stats?.player?.playerName} - {stats?.player?.fieldPosition}
          </Typography>
        </Grid>
        <Grid item xs={12}>
          <Typography variant="h6">Player Overview</Typography>
          <Card sx={{ mb: 3 }}>
            <CardContent>
              <Typography variant="body1">
                <strong>Name:</strong> {stats?.player?.playerName}
              </Typography>
              <Typography variant="body1">
                <strong>Position:</strong> {stats?.player?.fieldPosition}
              </Typography>
              <Typography variant="body1">
                <strong>Nationality:</strong> {stats?.player?.nationality}
              </Typography>
              <Typography variant="body1">
                <strong>Age:</strong> {stats?.player?.age}
              </Typography>
              <Typography variant="body1">
                <strong>Height:</strong> {stats?.player?.height} cm
              </Typography>
              <Typography variant="body1">
                <strong>Weight:</strong> {stats?.player?.weight} kg
              </Typography>
            </CardContent>
          </Card>
        </Grid>
        {renderStats()}
      </Grid>
    </Box>
  );
};

export default PlayerDetails;
