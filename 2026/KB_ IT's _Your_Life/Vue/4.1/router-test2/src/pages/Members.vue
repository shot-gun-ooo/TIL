<template>
  <div class="card card-body">
    <h2 class="m-4">이날치 그룹 Members</h2>
    <div class="container">
      <div class="row">
        <div
          class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2"
          v-for="m in members"
          :key="m.id"
        >
          <router-link :to="{ name: 'members/id', params: { id: m.id } }">
            <img 
              :src="m.photo" 
              class="img-thumbnail" 
              style="width: 100px; height: 100px; object-fit: cover;" 
            />
            <br />
            <span>{{ m.id }}-{{ m.name }}</span>
          </router-link>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import members from '@/members.json';
</script>