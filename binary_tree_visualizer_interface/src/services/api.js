import axios from "axios";

/* API Configuration and Endpoints */
const API_URL = "http://localhost:8080";

export const processNumbers = (numbers, balance = false) => {
  return axios.post(`${API_URL}/process-numbers?balance=${balance}`, numbers);
};

export const getPreviousTrees = () => {
  return axios.get(`${API_URL}/previous-trees`);
};
