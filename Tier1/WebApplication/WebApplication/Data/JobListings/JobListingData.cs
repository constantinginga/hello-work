using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Newtonsoft.Json;
using WebApplication.Models;
using WebApplication.Pages;
using JsonSerializer = System.Text.Json.JsonSerializer;

namespace WebApplication.Data
{
    public class JobListingData : IJobListingData
    {
        private WebApiUtil _client;
        public IList<JobListing> JobListings { get; private set; }
        private const string _url = "http://localhost:8082/job";

        public JobListingData()
        {
            JobListings = new List<JobListing>();
            _client = new WebApiUtil(_url);
        }

        public async Task<JobListing> Create(JobListing jobListing)
        {
            // store locally
            Random rand = new Random();
            jobListing.JobId = rand.Next();
            JobListings.Add(jobListing);
            string serializedJob = JsonSerializer.Serialize(jobListing);
            string response = await _client.Post("", serializedJob);
            JobListing job = JsonSerializer.Deserialize<JobListing>(response, new JsonSerializerOptions()
            {
            });
            return job;
        }

        public async Task<IList<JobListing>> GetJobListings()
        {
            // load once and store in variable
            if (!JobListings.Any())
            {
                string responese = await _client.Get("");
                JobListings = JsonSerializer.Deserialize<List<JobListing>>(responese, new JsonSerializerOptions()
                {
                });

                // have to do this because of the inheritance
                //     JsonSerializerSettings settings = new() {TypeNameHandling = TypeNameHandling.All};
                //     JobListings = JsonConvert.DeserializeObject<List<JobListing>>(responseBody, settings);
            }

            return JobListings;
        }

        public async Task Update(JobListing jobListing)
        {
            JobListing toUpdate = JobListings.First(j => j.JobId == jobListing.JobId);
            toUpdate.JobTitle = jobListing.JobTitle;
            toUpdate.JobType = jobListing.JobType;
            toUpdate.Location = jobListing.Location;
            toUpdate.ExperienceLevel = jobListing.ExperienceLevel;
            toUpdate.JobRequirments = jobListing.JobRequirments;
            toUpdate.JobPrivilleges = jobListing.JobPrivilleges;
            toUpdate.PhoneNumber = jobListing.PhoneNumber;
            toUpdate.Email = jobListing.Email;
            toUpdate.ApplicationDeadline = jobListing.ApplicationDeadline;


            /*StringContent queryString = new(JsonConvert.SerializeObject(adult), Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.PatchAsync(_url + $"/{adult.Id}", queryString);
            response.EnsureSuccessStatusCode();*/
        }

        public async Task<JobListing> Get(int id)
        {
            return JobListings.FirstOrDefault(j => j.JobId == id);
        }

    }
}