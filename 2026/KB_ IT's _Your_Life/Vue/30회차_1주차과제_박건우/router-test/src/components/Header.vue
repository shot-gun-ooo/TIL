<template>
  <nav class="navbar navbar-expand-md navbar-dark bg-dark"> 
    <span class="navbar-brand ps-2">이날치(LeeNalChi)</span> 
    
    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link class="nav-link" to="/">홈</router-link> 
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/about">소개</router-link> 
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/members">멤버</router-link> 
        </li>
        <li class="nav-item">
          <router-link class="nav-link" to="/videos">영상</router-link> 
        </li>
      </ul>
    </div>
  </nav>
</template>