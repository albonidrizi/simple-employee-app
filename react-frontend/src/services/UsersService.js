import axios from 'axios';

const USERS_API_BASE_URL = "http://localhost:8080/api/v1/user";

class UsersService {

    getUser() {
        return axios.get(USERS_API_BASE_URL);
    }

    createUser(user) {
        return axios.post(USERS_API_BASE_URL, user);
    }

    getUserById(userId) {
        return axios.get(USERS_API_BASE_URL + '/' + userId);
    }

    updateUser(user, userId) {
        return axios.put(USERS_API_BASE_URL + '/' + userId, user);
    }

    deleteUser(userId) {
        return axios.delete(USERS_API_BASE_URL + '/' + userId);
    }
}

export default new UsersService()