using System;
using System.Collections.Generic;
using System.Linq;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;
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
            int max = JobListings.Count != 0 ? JobListings.Max(j => j.JobId) : 0;
            jobListing.JobId = ++max;
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
            toUpdate.Details = jobListing.Details;

            /*StringContent queryString = new(JsonConvert.SerializeObject(adult), Encoding.UTF8, "application/json");
            HttpResponseMessage response = await client.PatchAsync(_url + $"/{adult.Id}", queryString);
            response.EnsureSuccessStatusCode();*/
        }

        public JobListing Get(int id)
        {
            return JobListings.FirstOrDefault(j => j.JobId == id);
        }
        
    }
}