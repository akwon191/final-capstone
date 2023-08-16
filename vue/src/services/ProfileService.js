import axios from 'axios';

export default {
    getMyProfile() {
        return axios.get('/profile')
    },

}