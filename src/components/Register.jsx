import { useState } from 'react';
import { Box, TextField, Button, Typography, Alert } from '@mui/material';
import { useNavigate } from 'react-router-dom';

const Register = () => {
  const navigate = useNavigate();
  const [formData, setFormData] = useState({
    usuario: '',
    nombre: '',
    email: '',
    password: '',
    confirmPassword: ''
  });
  const [error, setError] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (formData.password !== formData.confirmPassword) {
      setError('Passwords do not match');
      return;
    }

    try {
      const response = await fetch('http://localhost:8080/usuarios/crearusuario', {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify({
          usuario: formData.usuario,
          nombre: formData.nombre,
          email: formData.email,
          password: formData.password,
          rol: 'NORMAL'  // Asignamos el rol por defecto
        })
      });

      if (!response.ok) {
        const data = await response.json();
        throw new Error(data.message || 'Registration failed');
      }

      // Registro exitoso
      navigate('/login');
    } catch (err) {
      setError(err.message);
    }
  };

  const handleChange = (e) => {
    setFormData({
      ...formData,
      [e.target.name]: e.target.value
    });
  };

  return (
    <Box component="form" onSubmit={handleSubmit} sx={{ mt: 4, maxWidth: 400, mx: 'auto' }}>
      <Typography variant="h4" gutterBottom>
        Register
      </Typography>

      {error && (
        <Alert severity="error" sx={{ mb: 2 }}>
          {error}
        </Alert>
      )}

      <TextField
        fullWidth
        margin="normal"
        label="Username"
        name="usuario"
        value={formData.usuario}
        onChange={handleChange}
        required
      />

      <TextField
        fullWidth
        margin="normal"
        label="Full Name"
        name="nombre"
        value={formData.nombre}
        onChange={handleChange}
        required
      />

      <TextField
        fullWidth
        margin="normal"
        label="Email"
        name="email"
        type="email"
        value={formData.email}
        onChange={handleChange}
        required
      />

      <TextField
        fullWidth
        margin="normal"
        label="Password"
        name="password"
        type="password"
        value={formData.password}
        onChange={handleChange}
        required
      />

      <TextField
        fullWidth
        margin="normal"
        label="Confirm Password"
        name="confirmPassword"
        type="password"
        value={formData.confirmPassword}
        onChange={handleChange}
        required
      />

      <Button 
        type="submit" 
        variant="contained" 
        fullWidth 
        sx={{ mt: 2 }}
      >
        Register
      </Button>

      <Button 
        variant="text" 
        fullWidth 
        sx={{ mt: 1 }}
        onClick={() => navigate('/login')}
      >
        Already have an account? Login
      </Button>
    </Box>
  );
};

export default Register;