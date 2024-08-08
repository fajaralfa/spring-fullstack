<script setup>
import { useLogout } from '@/composables/useLogout';
import { useAuth } from '@/stores/auth';
import Button from 'primevue/button';

const { logout } = useLogout()

const auth = useAuth()

</script>

<template>
  <nav class="space-x-3 p-4 bg-green-500">
      <Button as="router-link" :to="{name: 'loan-books'}" label="Loans Books" />
      <Button as="router-link" :to="{name: 'books'}" label="Books" />
      <Button as="router-link" :to="{name: 'students'}" label="Students" />
      <Button @click="logout" class="font-bold" severity="warn" v-if="auth.user">Logout</Button>
      <Button as="router-link" :to="{name: 'login'}" severity="warn" v-else>Login</Button>
      <span class="float-right text-white font-bold">{{ auth.user?.name }}</span>
  </nav>
</template>