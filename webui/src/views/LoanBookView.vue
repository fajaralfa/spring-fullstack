<script setup>
import Button from 'primevue/button';
import NewLoanBookDialog from '@/components/NewLoanBookDialog.vue';
import ReturnBookDialog from '@/components/ReturnBookDialog.vue';
import { useAxios } from '@/composables/useAxios';
import { ref } from 'vue';

const { fetch, data } = useAxios('/api/v1/loan-books')
fetch()

const returnBookDialogVisible = ref(false)
const returnBookUrl = ref('')

const returnBookDialogAction = (url) => {
    returnBookUrl.value = url
    returnBookDialogVisible.value = true
}

</script>

<template>
    <div class="p-5">
        <NewLoanBookDialog />
    </div>
    <div>
        <table class="table table-fixed w-4/5 m-auto">
            <thead>
                <tr>
                    <td>Peminjam</td>
                    <td>NIS</td>
                    <td>Waktu Peminjaman</td>
                    <td>Batas Pengembalian</td>
                    <td>Waktu Pengembalian</td>
                </tr>
            </thead>
            <tbody>
                <tr v-for="item in data">
                    <td>{{ item.student.nama }}</td>
                    <td>{{ item.student.nis }}</td>
                    <td>{{ item.borrowTime }}</td>
                    <td>{{ item.expectedReturnTime }}</td>
                    <td>
                        <span v-if="item.returnTime">{{ item.returnTime }}</span>
                        <Button severity="warn" size="small" @click="returnBookDialogAction(`/api/v1/loan-books/${item.id}`)" v-else>{{ 'Belum Dikembalikan' }}</Button>
                    </td>
                </tr>
            </tbody>
        </table>
        <ReturnBookDialog :url="returnBookUrl" v-model:visible="returnBookDialogVisible" @updated="fetch()" />
    </div>
</template>


<style scoped>
td, th, tr {
    @apply border;
}
th, td {
    @apply px-2 py-1;
}
</style>