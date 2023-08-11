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
        <img src="@/assets/dandelion.png" alt="Flowers Image" class="flowers-image">
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

<style scoped>

#register {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 80vh;
  font-family: courgette;
  font-size: 1rem;
  color: #365016;
  background: whitesmoke;
  border: 10px solid #FF9B42;
  border-radius: 10px;
  width: calc(100% - 40px); 
  max-width: 500px; 
  margin: 0 auto;
  margin-top: 80px;
  box-sizing: border-box;  
  padding: 20px;
}

button[type="submit"] {
  background-color: whitesmoke;
  border: 2px solid #FF9B42;
  border-radius: 15px;
  font-family: courgette;
  color: #365016;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
}

button[type="submit"]:hover {
  background-color: #FF9B42;
  color: #365016;
}

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
  margin-bottom: 0;
  display: flex;
  justify-content: center;
  padding: 0; 
}

.fireworks-image {
  max-width: 460px;
  height: auto;
}

.flowers-container {
  text-align: left;
  margin-top: 0;
}

.flowers-image img {
  max-width: 300px;
  height: auto;
}
</style>
