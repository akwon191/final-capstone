import axios from 'axios';

export default {
    getMyProfile() {
        return axios.get('/profiles')
    },
    updateProfile() {
        return axios.put('/profiles')
    },

}