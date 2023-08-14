import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000';

export default {
    listImage() {
        return axios.get(API_BASE_URL +  "/{imageId}")
    },

    getImage(imageId) {
        return axios.get(API_BASE_URL + `/images/${imageId}`)

    },
    postImage(formdata) {
        return axios.post(API_BASE_URL + '/images/upload', formdata)
    }
    
}