import { useEffect, useState } from 'react';
import { getAllWorldCupWinner } from '../service/CommonService';
import WinnerCard from '../Component/WinnerCard';
import './Style/HomePage.scss';

const HomePage = () => {
    const [winnerList, setWinnerList] = useState([]);
    useEffect(() => {
        getAllWorldCupWinner().then((response) => {
            setWinnerList(response.data);
        })
    },[]);
    return (
        <>
            <div className='title'>World Cups Since 1975</div>
        <div className='home'>
                {winnerList.map((winner: any) => <WinnerCard winner={winner} key={ winner.id} />)}
        </div></>
    );
}
export default HomePage;