import React from 'react';
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import Button from '@mui/material/Button';
import IconButton from '@mui/material/IconButton';
import Sidebar from './Sidebar';
import { Link } from 'react-router-dom';

const Header = () => {
  return (
    <AppBar position="static">
      <Toolbar>
        <IconButton edge="start" color="inherit" aria-label="menu">
          <Sidebar />
        </IconButton>
        <Typography variant="h6" style={{ flexGrow: 1 }}>
          My Website
        </Typography>
        <Button color="inherit" component={Link} to='/'>Home</Button>
        <Button color="inherit" component={Link} to='/about'>About</Button>
      </Toolbar>
    </AppBar>
  );
};

export default Header;