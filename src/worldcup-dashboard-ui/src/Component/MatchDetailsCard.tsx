import { Link } from 'react-router-dom';
import './Style/MatchDetailsCard.scss';
const MatchDetailsCard = ({ matchDetails }: any) => {
    return (
        <div className='details'>
            
            <div className='countries'>
                <Link to={`/country/${matchDetails.team1}`}><h1>{matchDetails.team1}</h1></Link>
                <p>VS</p>
                <Link to={`/country/${matchDetails.team2}`}><h1>{matchDetails.team2}</h1></Link>
            </div>
            <div className='more-details'>
                <h5>{matchDetails.stage}</h5>
                <h6 style={{marginTop:'10px'}}>{matchDetails.date}</h6>
                <h6>At {matchDetails.ground} cricket ground</h6>
                <p style={{marginTop:'10px'}}>Player of the Match</p>
                <h5>{matchDetails.playerOfTheMatch}</h5>
            </div>
            <div className='match-details-result'><h3>{matchDetails.result}</h3></div>
        </div>
    )
}
export default MatchDetailsCard;