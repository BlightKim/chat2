import axios, {Axios} from "axios";

const client: Axios = axios.create({
  baseURL: import.meta.env.VITE_API_URL,
  headers: {
  }
})