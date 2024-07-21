import React from 'react';
import { Route, Routes } from 'react-router-dom';
import Header from './Header';
import { GetUser } from './GetUser';
import { GetAccount } from './GetAccount';
import Footer from './Footer';

function App() {
  return (
    <>
        <Header />
        <div className="App">
            <Routes>
                {/* <Route path="/" exact element={<HomePage />}  />
                <Route path="/about" element={<AboutPage />} />
                <Route path="/searchWeather" element={<WeatherApp />} /> */}
                {/* 他のページのルートを追加 */}
            </Routes>
        </div>
        <GetUser />
        <GetAccount />
        <Footer />
    </>
  );
}

export default App;