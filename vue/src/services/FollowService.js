import axios from 'axios';


export default {
    list() {
        return axios.get('/follow')
    },
    follow(followerId) {
        return axios.post(`/follow/${followerId}`)
    },
    unfollow(followerId) {
        return axios.delete(`/follow/${followerId}`)
    }

}