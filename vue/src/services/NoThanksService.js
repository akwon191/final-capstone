import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000';

export default {
  getNoThanksByUserId(userId) {
    const url = `${API_BASE_URL}/no_thanks/${userId}`;
    return axios
      .get(url)
      .then(response => response.data)
      .catch(error => {
        console.error('Error retrieving no thanks:', error);
        throw error;
      });
  },

  addNoThanks(postId, userId) {
    return axios.post(API_BASE_URL + `/no_thanks/${postId}/${userId}`);
  },

  removeNoThanks(postId, userId) {
    return axios.delete(API_BASE_URL + `/no_thanks/${postId}/${userId}`);
  },
};