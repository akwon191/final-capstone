<template>
    <header>
        <section>
            <div id="navigation-bar">
                <img id="logo" src="@/assets/Uplift logo1.png" alt="Uplift logo">
                <h1 id="uplift-title">Uplift</h1>
                <div id="navigation-buttons">
                    <router-link id="home" v-bind:to="{ name: 'home' }"><i class="fa-solid fa-house" style="color: #57614b;"></i></router-link>
                    <router-link id="my-vibes" v-bind:to="{ name: 'vibes' }"><i class="fa-solid fa-heart" style="color: #57614b;"></i></router-link>
                    <router-link id="upload" v-bind:to="{ name: 'upload' }"><i class="fa-solid fa-arrow-up-from-bracket" style="color: #57614b;"></i></router-link>
                    <router-link id="logout" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''"><i class="fa-solid fa-right-from-bracket" style="color: #57614b;"></i></router-link>
                    <router-link id="profile" v-bind:to="{ name: 'profile' }"><i class="fa-solid fa-user" style="color: #57614b;"></i></router-link>
                </div>
            </div>
        </section>
    </header>
</template>

<script>

export default {
    name: 'page-headers',
    components: {
    }
}

</script>



<style>
    @import url('https://fonts.googleapis.com/css2?family=Courgette&family=Lobster&display=swap');

    html, body {
    height: 100%;
    margin: 0;
    }

    #navigation-bar {
        display: flex;
        flex-direction: row;
        align-items: center;
        position: sticky;
        border-bottom: 10px solid #E85E6A;
        background-color: whitesmoke;
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    }

    #logo {
        max-width: 80px; 
        height: auto;
    }

    #uplift-title {
        font-family: 'Courgette';
        font-size: 2.5rem;
        color: #365016;
        margin: 10px;
        text-shadow: 0px 0px 1px black;
    }

    #navigation-buttons {
        display: flex;
        font-size: 2rem;
        flex-grow: 1;
        justify-content: space-evenly;
    }


</style>