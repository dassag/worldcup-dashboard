import axios from 'axios'

export const getAllMatchOfTheYear = async (year) => {
    return await axios.get(`http://localhost:8080/winner/${year}`);
}