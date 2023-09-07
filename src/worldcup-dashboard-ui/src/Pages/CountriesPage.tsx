import { useEffect, useState } from 'react';
import { getAllCountries } from '../service/CommonService';
import CountryList from '../Component/CountryList';

const Countries = () => {
    const [countryList, setCountryList] = useState([]);
        useEffect(() => {
            getAllCountries().then((response) => {
            setCountryList(response.data);
        })
        }, []);
    
    return (<div className='country-grid'>
                {countryList.map((country: any) => <CountryList countryName={country.countryName} key={country.id} />)}
    </div>)
}
export default Countries;