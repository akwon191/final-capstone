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
    listFavorites() {
        return axios.get('/favorites')
    },
    addFavorite(postId) {
        return axios.post(`/favorites/${postId}`)
    },
    removeFavorite(postId) {
        return axios.delete(`/favorites/${postId}`)
    },
}