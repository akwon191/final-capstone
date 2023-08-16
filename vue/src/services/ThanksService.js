import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000';

export default {
  getThanksByUserId(userId) {
    const url = `${API_BASE_URL}/thanks/${userId}`;
    return axios
      .get(url)
      .then(response => response.data)
      .catch(error => {
        console.error('Error retrieving thanks:', error);
        throw error;
      });
  },

  addThanks(postId, userId) {
    return axios.post(API_BASE_URL + `/thanks/${postId}/${userId}`);
  },

  removeThanks(postId, userId) {
    return axios.delete(API_BASE_URL + `/thanks/${postId}/${userId}`);
  },
};