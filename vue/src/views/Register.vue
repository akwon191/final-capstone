<template>
  <div id="register" class="text-center">
    <div class="image-container">
      <img src="@/assets/fireworks.png" alt="Fireworks Image" class="fireworks-image">
    </div>
    <form @submit.prevent="register">
      <h1>Be the Moment</h1> 
      <h1>Create Vibes with Us</h1>
      <div role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <div class="form-input-group">
        <label for="confirmPassword">Double check Password vibes</label>
        <input type="password" id="confirmPassword" v-model="user.confirmPassword" required />
      </div>
      <button type="submit">Create Account</button> 
      <p><router-link :to="{ name: 'login' }">Already have an account? Log in.</router-link></p>
    </form>
       <div class="flowers-image">
        <img src="@/assets/Bottom2.png" alt="Flowers Image" class="flowers-image">
      </div>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
  },
};
</script>

<style >
@import "@/assets/style.css";

.form-input-group {
  margin-bottom: 1rem;
}

label {
  margin-right: 0.5rem;
}

.image-container {
  text-align: center;
  
}

.fireworks-container {
  display: flex;
  justify-content: flex-end; 
  align-items: flex-start;
  margin-top: -100px;
  position: relative;
}

.fireworks-image {
  max-width: 0px;
  height: auto;
}

.flowers-container {
  text-align: left;
  margin-top: 30;
}

.flowers-image img {
  max-width: 400px;
  height: auto;
}
</style>
