import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { getAllMatchOfTheYear, getWinnerByYear } from '../service/CommonService';
import MatchCard from '../Component/MatchCard';
import './Style/MatchPage.scss';

const MatchPage = () => {
    const params: any = useParams();
    const [matchList, setMatchList] = useState([]);
    const [winner, setWinner] = useState<any>({});

    useEffect(() => {
        getWinnerByYear(params.id).then((response) => {;
            setWinner(response.data);
        })
        getAllMatchOfTheYear(params.id).then((response) => {
            setMatchList(response.data);
        })
    },[params.id]);
    return (
        <>
            <div className='match-title'>
                {winner.name} - {winner.id}
            </div>
            <div className='match'>
                {matchList.map((match: any) => <MatchCard match={match} key={ match.id} />)}
            </div>
        </>
    );
}
export default MatchPage;