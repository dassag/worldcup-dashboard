import { useEffect, useState } from 'react';
import { useParams } from 'react-router';
import { getAllCountries, getCountryDetailsByName, getYearsWon } from '../service/CommonService';
import './Style/CountryPage.scss';
import StarComp from '../Component/StarComp';
import WinLossPieChart from '../Component/WinLossPieChart';
import CountryList from '../Component/CountryList';

const CountryPage = () => {
    const params: any = useParams();
    const countryName = params.name;
    const [country, setCountry] = useState<any>({});
    const [countryList, setCountryList] = useState([]);
    const [years, setYears] = useState([]);

    useEffect(() => {
        getCountryDetailsByName(countryName).then((response) => {
            setCountry(response.data);
        })
        getYearsWon(countryName).then((response) => {
            setYears(response.data);
        })
    }, [countryName]);

        useEffect(() => {
            getAllCountries().then((response) => {
            setCountryList(response.data);
        })
        }, []);

    return (
        <div className='country'>
            <div className='country-list'>
                {countryList.map((country: any, index:number) => <CountryList countryName={country.countryName} key={index} />)}
            </div>
            <div className='country-details'>
            <div className='countryName'>{country.countryName}</div>
                <p className='pie-chart'><WinLossPieChart totalWins={country.totalWins} totalLoss={country.totalMatchesPlayed - country.totalWins} /></p>
                {country.worldCupCount !== null && <div className='worldcup-details'>{[...Array(country.worldCupCount)]
                    .map((value: undefined, index: number) => (
                        <span key={index}><StarComp key={index} /></span>))}
                    <h5>{years.map((year: any, index: number) => <span style={{padding:'5px'}} key={index}>{ year}</span>)}</h5>
                </div>}
                </div>
        </div>
    );
    
}
export default CountryPage;