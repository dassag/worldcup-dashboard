import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { getMatchByYearAndId } from '../service/CommonService';
import MatchDetailsCard from '../Component/MatchDetailsCard';
import './Style/MatchDetailsPage.scss';

const MatchDetailsPage = () => {
    const params: any = useParams();
    const [matchDetails, setMatchDetails] = useState<any>({});

    useEffect(() => {
        getMatchByYearAndId(params.year, params.id).then((response) => {
            setMatchDetails(response.data);
        })
    }, [params.year, params.id])
    return (
        <div className='match-details'>
            <MatchDetailsCard matchDetails = {matchDetails}/>
        </div>
    )
}
export default MatchDetailsPage;