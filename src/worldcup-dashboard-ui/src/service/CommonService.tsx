import axios from 'axios'; 

export const getAllWorldCupWinner = () => {
    return axios.get(`/winner`);
}

export const getWinnerByYear = (year:number) => {
    return axios.get(`/winner/${year}`);
}

export const getCountryDetailsByName = (name: string) => {
    return axios.get(`/country/${name}`);
}

export const getAllMatchOfTheYear = (year: number) => {
    return axios.get(`/match/${year}`)
}

export const getMatchByYearAndId = (year: number, id:number) => {
    return axios.get(`/match/${year}/${id}`);
}

export const getAllCountries = () => {
    return axios.get(`/countries`);
}

export const getYearsWon = (name: string) => {
    return axios.get(`/winner/country/${name}`);
}