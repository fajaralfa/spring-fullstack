<script setup>
import Button from 'primevue/button';
import Dialog from 'primevue/dialog';
import DatePicker from 'primevue/datepicker';
import Select from 'primevue/select';
import MultiSelect from 'primevue/multiselect';
import { computed, onBeforeMount, ref, watch, watchEffect } from 'vue';
import { useAxios } from '@/composables/useAxios';
import { date } from '@/utils/date';

const { fetch: fetchBooks, data: booksResponse } = useAxios('/api/v1/books')
const { fetch: fetchStudents, data: studentsResponse } = useAxios('/api/v1/students')

const input = ref({
    studentId: null,
    bookIds: [],
    borrowTime: '',
    expectedReturnTime: '',
})
const postInput = computed(() => {
    return {
        studentId: input.value.studentId,
        bookIds: input.value.bookIds,
        borrowTime: date(input.value.borrowTime),
        expectedReturnTime: date(input.value.expectedReturnTime),
    }
})
const { fetch: postLoanBooks, loading: postLoanBooksLoading } = useAxios('/api/v1/loan-books', 'POST', postInput)
const postLoanBooksAction = async () => {
    await postLoanBooks()
    visible.value = false
}

onBeforeMount(() => {
    fetchBooks()
    fetchStudents()
})

const visible = ref(false)
</script>

<template>
    <Button @click="visible = true">New Loan Book</Button>
    <Dialog v-model:visible="visible" header="Pinjam Buku">
        <div class="space-y-3 w-96 *:w-full">
            <div>
                <Select
                    v-model="input.studentId"
                    editable
                    option-label="nama"
                    option-value="id"
                    :options="studentsResponse?._embedded.students" placeholder="Pilih siswa" class="w-full" />
            </div>
            <div>
                <MultiSelect
                    v-model="input.bookIds"
                    option-label="title"
                    option-value="id"
                    :options="booksResponse?._embedded.books" placeholder="Pilih buku" class="w-full" />
            </div>
            <div>
                <DatePicker v-model="input.borrowTime" placeholder="Waktu Pinjam" class="w-full" />
            </div>
            <div>
                <DatePicker v-model="input.expectedReturnTime" placeholder="Waktu Mengembalikan" class="w-full" />
            </div>
            <Button @click="postLoanBooksAction" :disabled="postLoanBooksLoading">Buat</Button>
        </div>
    </Dialog>
</template>