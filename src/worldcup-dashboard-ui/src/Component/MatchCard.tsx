import { Link } from 'react-router-dom';
import './Style/MatchCard.scss';

const MatchCard = ({match}:any) => {
    return (
        <div className='match-card'>
            <Link to={`/matches/${match.year}/${match.id}`}>
                <h3 className='match-teams'>{match.team1} VS {match.team2}</h3>
                <h5 className='match-result'> {match.result}</h5>
            </Link>
        </div>
    )
}
export default MatchCard;