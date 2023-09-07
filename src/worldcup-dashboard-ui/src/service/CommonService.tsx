import axios from 'axios'; 

export const getAllWorldCupWinner = () => {
    return axios.get(`http://localhost:8080/winner`);
}

export const getWinnerByYear = (year:number) => {
    return axios.get(`http://localhost:8080/winner/${year}`);
}

export const getCountryDetailsByName = (name: string) => {
    return axios.get(`http://localhost:8080/country/${name}`);
}

export const getAllMatchOfTheYear = (year: number) => {
    return axios.get(`http://localhost:8080/match/${year}`)
}

export const getMatchByYearAndId = (year: number, id:number) => {
    return axios.get(`http://localhost:8080/match/${year}/${id}`);
}

export const getAllCountries = () => {
    return axios.get(`http://localhost:8080/countries`);
}

export const getYearsWon = (name: string) => {
    return axios.get(`http://localhost:8080/winner/country/${name}`);
}