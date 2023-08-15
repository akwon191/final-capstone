import axios from "axios";

const API_BASE_URL = "http://localhost:9000";

export default {
  getVibesByUserId(userId) {
    const url = `${API_BASE_URL}/vibes/${userId}`;
    return axios
      .get(url)
      .then(response => response.data)
      .catch(error => {
        console.error('Error retrieving vibes:', error);
        throw error;
      });
  },

  addVibe(vibe) {
    return axios.post(API_BASE_URL + '/vibes', vibe)
  },
  removeVibe(postId) {
    return axios.delete(API_BASE_URL + `/vibes/${postId}`)
},
};