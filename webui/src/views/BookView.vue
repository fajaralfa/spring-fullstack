<script setup>
import Button from 'primevue/button';
import NewBookFormDialog from '@/components/NewBookFormDialog.vue';
import { onBeforeMount } from 'vue';
import { useGetBooks } from '@/composables/useGetBooks';
import axios from 'axios';

const { books, fetch } = useGetBooks()

onBeforeMount(async () => await fetch())

const deleteBook = async (url) => {
    if(!confirm('hapus data ini?')) return
    await axios.delete(url)
    await fetch()
}

</script>

<template>
    <div class="p-5">
        <NewBookFormDialog @stored="fetch()" />
    </div>
    <div>
        <table class="table table-fixed">
            <thead>
                <tr>
                    <th>Title</th>
                    <th>Author</th>
                    <th>Description</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="book in books" :key="book.id">
                    <td>{{ book.title }}</td>
                    <td>{{ book.author }}</td>
                    <td>{{ book.description }}</td>
                    <td>
                        <Button severity="secondary" @click="">^</Button>
                        <Button severity="danger" @click="deleteBook(book._links.self.href)">X</Button>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<style scoped>
tr, td, th {
    @apply border;
}
th, td {
    @apply px-2 py-1;
}
</style>