import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      component: () => import('@/views/AuthLayout.vue'),
      children: [
        {
          path: '',
          name: 'home',
          redirect: '/book-loans',
        },
        {
          path: '/books',
          name: 'books',
          component: () => import('@/views/BookView.vue'),
        },
        {
          path: '/students',
          name: 'students',
          component: () => import('@/views/StudentView.vue'),
        },
        {
          path: '/book-loans',
          name: 'book-loans',
          component: () => import('@/views/BookLoanView.vue'),
        }

      ]
    },
    {
      path: '/register',
      name: 'register',
      component: () => import('@/views/RegisterView.vue'),
    },
    {
      path: '/login',
      name: 'login',
      component: () => import('@/views/LoginView.vue'),
    },
  ]
})

export default router
