import axios from 'axios';

export const getAllCupWinners = async () => {
    return await axios.get(`http://localhost:8080/winner`);
}