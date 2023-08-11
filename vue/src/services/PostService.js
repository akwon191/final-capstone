import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000';

export default {
    listPosts() {
        return axios.get(API_BASE_URL + '/posts')
    },

    getPost(postId) {
        return axios.get(API_BASE_URL + '/posts/' + postId)
    },
    addPost(Post) {
        return axios.post(API_BASE_URL + '/posts', Post)
    },
    listVibes() {
        return axios.get('/vibes')
    },
    addVibe(postId) {
        return axios.post(`/vibes/${postId}`)
    },
    removeVibe(postId) {
        return axios.post(`/vibes/${postId}`)
    },
}