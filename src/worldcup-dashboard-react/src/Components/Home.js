import React, { useEffect, useState } from 'react';
import { getAllCupWinners } from '../Services/WinnerService';
import { CardComp } from './CardComp';
import './Home.css';
const Home = () => {
    const [country, setCountry] = useState();

    useEffect(() => {
        getAllCupWinners().then((response) => {
            setCountry(response.data);
        })
    }, []);
    return (
        <>
            <div className='Home'>
                <div className='home-header'><h1>Men's Cricket WorldCup</h1></div>
                {country !== null && country !== undefined && country.map((winner,index) => 
                    <CardComp winner={winner}></CardComp>
                )}
            </div>
        </>);
}
export default Home;