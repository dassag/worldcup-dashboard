import { Link } from 'react-router-dom';

const CountryList = ({countryName}:any) => {
    return (
        <ul><li style={{textAlign:'left'}}><Link to={`/country/${countryName}`}><h4>{ countryName}</h4></Link></li></ul>
    );
}
export default CountryList;