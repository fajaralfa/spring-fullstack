<script setup>
import { useAxios } from '@/composables/useAxios';
import { date } from '@/utils/date';
import Button from 'primevue/button';
import DatePicker from 'primevue/datepicker';
import Dialog from 'primevue/dialog';
import { computed, ref } from 'vue';

const props = defineProps({
    url: '',
})

const emit = defineEmits(['updated'])

const visible = defineModel('visible')

const returnTime = ref()
const input = computed(() => ({
    returnTime: date(returnTime.value)
}))

const { fetch } = useAxios(null, 'PUT', input)
const returnBookAction = async () => {
    console.log('props ', props.url);
    
    await fetch(props.url)
    emit('updated')
    visible.value = false
}

</script>

<template>
    <Dialog v-model:visible="visible" header="Pengembalian Buku">
        <div class="*:w-full space-y-5">
            <DatePicker v-model="returnTime" placeholder="Tanggal Pengembalian" />
            <Button @click="returnBookAction">Simpan</Button>
        </div>
    </Dialog>
</template>