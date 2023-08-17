import Vue from 'vue'
import Vuex from 'vuex'
import axios from 'axios'
import VibeService from '../services/VibeService'
import ThanksService from '../services/ThanksService';
import NoThanksService from '../services/NoThanksService';
Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    posts: [],
    vibes: [],
    thanks: [],
    noThanks: [],
    profile: [],
  },
  getters: {
    filteredPosts(state) {
      if (state.vibes.length === 0) {
        return state.posts;
      }
      return state.posts.filter(post => state.vibes.includes(post.postId));
    },
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    setPosts(state, posts) {
      state.posts = posts;
    },
    setVibes(state, vibes) {
      state.vibes = vibes;
    },
    SET_THANKS(state, thanks) {
      state.thanks = thanks;
    },
    SET_NO_THANKS(state, noThanks) {
      state.noThanks = noThanks;
    },
    SET_PROFILE(state, profile) {
      state.profile = profile;
    }
  },
  actions: {
    fetchPosts({ commit }) {
      axios.get('http://localhost:9000/posts')
        .then(response => {
          commit('setPosts', response.data);
          if (response.data.length > 0) {
            // ...
          }
        })
        .catch(error => {
          console.error('Error fetching posts:', error);
        });
    },
    fetchVibesByUserId({ commit }, userId) {
      return VibeService.getVibesByUserId(userId)
        .then(vibes => {
          commit('setVibes', vibes);
        })
        .catch(error => {
          console.error('Error fetching vibes:', error);
        });
    },
    fetchThanksByUserId({ commit }, userId) {
      return ThanksService.getThanksByUserId(userId)
        .then(thanks => {
          commit('SET_THANKS', thanks);
        })
        .catch(error => {
          console.error('Error fetching thanks:', error);
        });
    },
    fetchNoThanksByUserId({ commit }, userId) {
      return NoThanksService.getNoThanksByUserId(userId)
        .then(noThanks => {
          commit('SET_NO_THANKS', noThanks);
        })
        .catch(error => {
          console.error('Error fetching noThanks:', error);
        });
    },
  }
})