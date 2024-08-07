import { storageGet, storageRemove, storageSet } from "@/utils/localStorage";
import axios from "axios";
import { defineStore } from "pinia";

const USER_KEY = 'BOOKLOAN_USER'
const TOKEN_KEY = 'BOOKLOAN_TOKEN'

export const useAuth = defineStore('auth', {
    state: () => ({
        user: JSON.parse(storageGet(USER_KEY)),
        token: storageGet(TOKEN_KEY),
    }),

    actions: {
        async login(data) {
            let res
            res = await axios.post('/api/v1/auth/login', data)
            this.setToken(res.data.token)
            res = await axios.get('/api/v1/users/current')
            this.setUser(res.data)
        },

        async logout() {
            this.removeToken()
            this.removeUser()
        },

        setToken(token) {
            this.token = token
            storageSet(TOKEN_KEY, token)
            axios.defaults.headers.common.Authorization = `Bearer ${token}`
        },

        removeToken() {
            this.token = null
            storageRemove(TOKEN_KEY)
            delete axios.defaults.headers.common.Authorization
        },

        setUser(user) {
            this.user = user
            storageSet(USER_KEY, JSON.stringify(user))
        },

        removeUser() {
            this.user = null
            storageRemove(USER_KEY)
        }
    }
})