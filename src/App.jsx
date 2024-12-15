// src/App.jsx
import { BrowserRouter as Router, Routes, Route, Navigate } from 'react-router-dom';
import Navbar from './components/Navbar';
import Login from './components/Login';
import Register from './components/Register';
import Teams from './components/Teams';
import Players from './components/Players';
import TeamDetail from './components/TeamDetail';
import PlayerDetails from './components/PlayerDetails';

const PrivateRoute = ({ children }) => {
  const isAuthenticated = !!localStorage.getItem('token');
  return isAuthenticated ? children : <Navigate to="/login" />;
};

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route
          path="/teams"
          element={
            <PrivateRoute>
              <Teams />
            </PrivateRoute>
          }
        />
        <Route
          path="/teams/:id"
          element={
            <PrivateRoute>
              <TeamDetail />
            </PrivateRoute>
          }
        />
        <Route
          path="/players"
          element={
            <PrivateRoute>
              <Players />
            </PrivateRoute>
          }
        />
        <Route path="/players/:playerId" element={<PlayerDetails />} />
        <Route path="/" element={<Navigate to="/teams" />} />
      </Routes>
    </Router>
  );
}

export default App;