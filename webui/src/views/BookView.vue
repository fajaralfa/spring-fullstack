<script setup>
import Button from 'primevue/button';
import NewBookFormDialog from '@/components/NewBookFormDialog.vue';
import { onBeforeMount, ref, watch } from 'vue';
import UpdateBookFormDialog from '@/components/UpdateBookFormDialog.vue';
import { useAxios } from '@/composables/useAxios';

const { fetch } = useAxios('/api/v1/books')

const books = ref([])
onBeforeMount(async () => {
    books.value = (await fetch()).data._embedded.books
})

</script>

<template>
    <div class="p-5">
        <NewBookFormDialog @result="fetch()" />
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
                        <Button severity="danger" @click="">X</Button>
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