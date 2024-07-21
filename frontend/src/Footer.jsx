import React from 'react';
import Typography from '@mui/material/Typography';
import Link from '@mui/material/Link';
import './Footer.css';

const Footer = () => {
  return (
    <footer className="footer">
      <Typography variant="body1">
        &copy; 2024 My Website. All rights reserved.
      </Typography>
      <Typography variant="body2">
        Created with React and Material-UI.
      </Typography>
      <Typography variant="body2">
        <Link href="#">Privacy Policy</Link> | <Link href="#">Terms of Service</Link>
      </Typography>
    </footer>
  );
};

export default Footer;