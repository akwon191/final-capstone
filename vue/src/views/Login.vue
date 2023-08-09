<template>
  <div id="login">
     <div class="header-container">
      <div class="welcome-header">
        <h1>Welcome to Uplift</h1>
      </div>
      <div class="login-image">
        <img src="@/assets/Uplift logo1.png" alt="Uplift logo"> 
      </div>
    </div>
    <form @submit.prevent="login">
      <h1 >Please Sign In</h1>
      <div role="alert" v-if="invalidCredentials">
        Invalid username and password!
      </div>
      <div role="alert" v-if="this.$route.query.registration">
        Thank you for registering, please sign in.
      </div>
      <div class="form-input-group">
        <label for="username">Username</label>
        <input type="text" id="username" v-model="user.username" required autofocus />
      </div>
      <div class="form-input-group">
        <label for="password">Password</label>
        <input type="password" id="password" v-model="user.password" required />
      </div>
      <button type="submit">Sign in</button>
      <p>
      <router-link :to="{ name: 'register' }">Need an account? Sign up.</router-link></p>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    }
  }
};
</script>

<style scoped>
 @import url('https://fonts.googleapis.com/css2?family=Courgette&family=Lobster&display=swap');

#login {
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
  box-sizing: border-box; 
  padding: 20px;
}

.welcome-header {
  text-align: center;
  margin-bottom: 20px; 
  
}
 .login-image {
  display: flex;
  justify-content: center; 
  align-items: center; 
}

.login-image img {
  max-width: 100px; 
  height: auto;
}

.login-box {
  border: 1px solid #ccc;
  padding: 20px;
  max-width: 400px;
  width: 100%;
  box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
}

.form-input-group {
  margin-bottom: 1rem;
}
label {
  margin-right: 0.5rem;
}
</style>