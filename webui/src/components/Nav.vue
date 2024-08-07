<script setup>
import { useLogout } from '@/composables/useLogout';
import Button from 'primevue/button';

const { logout } = useLogout()

</script>

<template>
  <nav class="space-x-3 p-4 bg-green-500">
      <Button as="router-link" :to="{name: 'book-loans'}" label="Book Loans" />
      <Button as="router-link" :to="{name: 'books'}" label="Books" />
      <Button as="router-link" :to="{name: 'students'}" label="Students" />
      <Button @click="logout" class="font-bold" severity="warn">Logout</Button>
  </nav>
</template>