import './assets/main.css'

import { createApp } from 'vue'
import { createPinia } from 'pinia'
import PrimeVue from 'primevue/config'
import Nora from '@primevue/themes/nora'

import App from './App.vue'
import router from './router'
import axios from 'axios'
import { useAuth } from './stores/auth'

const app = createApp(App)

app.use(createPinia())
app.use(router)
app.use(PrimeVue, {
    theme: {
        preset: Nora
    }
})

const auth = useAuth()

axios.defaults.baseURL = 'http://localhost:8080'
axios.defaults.headers.common.Authorization = `Bearer ${auth.token}`

app.mount('#app')
