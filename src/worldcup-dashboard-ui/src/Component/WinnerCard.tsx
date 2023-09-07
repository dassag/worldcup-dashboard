import './Style/WinnerCard.scss';
import { Link } from 'react-router-dom';
const WinnerCard = ({winner}:any) => {
    return (
        <div className='winner-card'>
            <Link to={`/matches/${winner.id}`}>
                <h3>{winner.name} - {winner.id}</h3>
                <h5>Won by {winner.winner}</h5>
            </Link>
        </div>
    )
}
export default WinnerCard;