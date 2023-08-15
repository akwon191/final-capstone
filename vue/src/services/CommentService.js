import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000';

export default {
    listComments() {
        return axios.get(API_BASE_URL + '/comments');
    },

    getComment(postId) {
        return axios.get(API_BASE_URL + '/comments/posts/' + postId);
    },
   
    createComment(comment) {
        return axios.post(API_BASE_URL + '/comments', comment)

}
}



